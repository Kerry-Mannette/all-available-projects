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
    public class DeleteModel : PageModel
    {
        private readonly RazorPagesRental.Data.RazorPagesCarsContext _context;

        public DeleteModel(RazorPagesRental.Data.RazorPagesCarsContext context)
        {
            _context = context;
        }

        [BindProperty]
        public Cars Cars { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var cars = await _context.Cars.FirstOrDefaultAsync(m => m.Id == id);

            if (cars is not null)
            {
                Cars = cars;

                return Page();
            }

            return NotFound();
        }

        public async Task<IActionResult> OnPostAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var cars = await _context.Cars.FindAsync(id);
            if (cars != null)
            {
                Cars = cars;
                _context.Cars.Remove(Cars);
                await _context.SaveChangesAsync();
            }

            return RedirectToPage("./Index");
        }
    }
}
