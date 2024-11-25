using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Data;
using RazorPagesRental.Models;

namespace RazorPagesRental.Pages_Customers
{
    public class DetailsModel : PageModel
    {
        private readonly RazorPagesRental.Data.RazorPagesCustomersContext _context;

        public DetailsModel(RazorPagesRental.Data.RazorPagesCustomersContext context)
        {
            _context = context;
        }

        public Customers Customers { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var customers = await _context.Customers.FirstOrDefaultAsync(m => m.Id == id);

            if (customers is not null)
            {
                Customers = customers;

                return Page();
            }

            return NotFound();
        }
    }
}
