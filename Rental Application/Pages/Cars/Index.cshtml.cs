using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Data;
using RazorPagesRental.Models;

namespace RazorPagesRental.Pages_Cars
{
    public class IndexModel : PageModel
    {
        private readonly RazorPagesRental.Data.RazorPagesCarsContext _context;

        public IndexModel(RazorPagesRental.Data.RazorPagesCarsContext context)
        {
            _context = context;
        }

        public IList<Cars> Cars { get;set; } = default!;

        [BindProperty(SupportsGet = true)]
        public string? SearchString { get; set; }

        public async Task OnGetAsync()
        {
            var cars = from m in _context.Cars
                 select m;
            if (!string.IsNullOrEmpty(SearchString))
            {
                cars = cars.Where(s => s.Brand.Contains(SearchString));
            }

            Cars = await cars.ToListAsync();
        }
    }
}
